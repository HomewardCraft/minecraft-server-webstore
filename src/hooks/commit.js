import setCurrentToastComponent from "./setToastComponent.js";
import isBlank from "./isBlank.js";
import {useCookies} from "vue3-cookies";
import axios from "axios";
import pubsub from "pubsub-js";

const {cookies} = useCookies()

const checkCategory = (category) => {
    if (category === '类型') {
        setCurrentToastComponent('fail', '请选择类型')
        return false
    }
    return category.toLowerCase()
}
const checkName = (name) => {
    if (isBlank(name)) {
        setCurrentToastComponent('fail', '请输入名称')
        return false
    }
    return true
}
const checkPrice = (price) => {
    if (isBlank(price)) {
        setCurrentToastComponent('fail', '请设置价格')
        return false
    }
    if (!Number.isInteger(price)) {
        setCurrentToastComponent('fail', '请输入有效价格整数')
        return false
    }
    if (price.toString().length > 7) {
        setCurrentToastComponent('fail', '请输入有效价格长度, 当前长度: ' + price.toString().length)
        return false
    }
    if (price < 100) {
        setCurrentToastComponent('fail', '请输入有效价格数量, 当前价格: ' + price / 100 + '元 (' + price + ')')
        return false
    }
    return true
}
const checkCommand = (command) => {
    if (isBlank(command)) {
        setCurrentToastComponent('fail', '请输入指令')
        return false
    }
    return true
}
const checkDescription = (markdownText) => {
    if (isBlank(markdownText)) {
        setCurrentToastComponent('fail', '请描述这个物品')
        return false
    } else {
        if (markdownText.toString().length <= 16) {
            setCurrentToastComponent('fail', '描述不能过短, 当前长度: ' + markdownText.toString().length)
            return false
        }
    }
    return true
}
const checkImageAddress = (category, imageAddress) => {
    if (category === 'extras' && isBlank(imageAddress.extras)) {
        setCurrentToastComponent('fail', '请上传图片')
        return false
    } else if (category === 'crates') {
        if (isBlank(imageAddress.crates.regular)) {
            setCurrentToastComponent('fail', '请上传图片')
            return false
        }
        if (isBlank(imageAddress.crates.hover)) {
            setCurrentToastComponent('fail', '请上传图片')
            return false
        }
    }
    return true
}
const checkDiscount = (discount) => {
    if (!Number.isInteger(discount)) {
        setCurrentToastComponent('fail', '请输入有效折扣整数')
        return false
    }
    if (discount <= 0 || discount.toString().length > 2) {
        setCurrentToastComponent('fail', '请输入有效折扣数量, 当前折扣: ' + discount + '%')
        return false
    }
    return true
}

async function insert(cache) {
    const type = checkCategory(cache.category)
    if (!type) return false

    if (!checkName(cache.name)) return false
    if (!checkPrice(cache.price)) return false
    if (!checkCommand(cache.command)) return false
    if (!checkDescription(cache.markdownText)) return false
    if (!checkImageAddress(type, cache.imageAddress)) return false

    let isDiscount
    let x1
    let x5
    let x10
    let x20
    if (type === 'extras') {
        isDiscount = !isBlank(cache.discount)
        if (isDiscount && !checkDiscount(cache.discount)) return false
    }
    if (type === 'crates') {
        x1 = !isBlank(cache.multiDiscount.x1)
        x5 = !isBlank(cache.multiDiscount.x5)
        x10 = !isBlank(cache.multiDiscount.x10)
        x20 = !isBlank(cache.multiDiscount.x20)
        if (x1 && !checkDiscount(cache.multiDiscount.x1)) return false
        if (x5 && !checkDiscount(cache.multiDiscount.x5)) return false
        if (x10 && !checkDiscount(cache.multiDiscount.x10)) return false
        if (x20 && !checkDiscount(cache.multiDiscount.x20)) return false
    }

    const data = {
        type: cache.category,
        name: cache.name,
        price: cache.price,
        saleCondition: null,
        rawSalePercent: null,
        command: cache.command,
        imageAddress: null,
        imageHoverAddress: null,
        description: cache.htmlText,
        rawDescription: cache.markdownText
    }

    if (type === 'extras') {
        data.saleCondition = isDiscount
        if (!isDiscount) data.rawSalePercent = 100
        else data.rawSalePercent = cache.discount
        data.imageAddress = cache.imageAddress.extras
    } else {
        data.rawSalePercent = JSON.stringify(cache.multiDiscount)
        data.imageAddress = cache.imageAddress.crates.regular
        data.imageHoverAddress = cache.imageAddress.crates.hover
    }
    console.log(data)
    const {
        data: result
    } = await axios.post('local/admin/insert', data, {
        headers: {
            'Authorization': cookies.get('authorization')
        }
    })
    if (result.status === 200) {
        setCurrentToastComponent('success', '添加成功')
        pubsub.publish('openEditorPanel')
        pubsub.publish('cleanInsertCache')
        return true
    } else {
        setCurrentToastComponent('fail', result.message)
        return false
    }
}

async function update(information) {
    console.log(information)
    // const {data:result} = await axios.post('local/admin/update', data, {
    // // const {data:result} = await axios.post('baioretto/webstore/api/admin/update', formData, {
    //   headers: {
    //     'Authorization': cookies.get('authorization')
    //   }
    // })
    // if (result.status === 200) setCurrentToastComponent('success', '更新成功')
    // else setCurrentToastComponent('fail', '更新失败')
}

export {insert, update}