import setCurrentToastComponent from "./setToastComponent.js";
import axios from "axios";
import isBlank from "./isBlank.js";
import {useCookies} from "vue3-cookies";

const {cookies} = useCookies()

function discountCheck(target) {
    if (!Number.isInteger(target)) {
        setCurrentToastComponent('fail', '请输入有效折扣整数')
        return false
    }
    if (target.toString().length > 2) {
        setCurrentToastComponent('fail', '请输入有效折扣长度, 当前长度: ' + target.toString().length)
        return false
    }
    if (target <= 0) {
        setCurrentToastComponent('fail', '请输入有效折扣数量, 当前折扣: ' + target + '%')
        return false
    }
    return true
}

function priceCheck(target) {
    if (!Number.isInteger(target)) {
        setCurrentToastComponent('fail', '请输入有效价格整数')
        return false
    }
    if (target.toString().length > 7) {
        setCurrentToastComponent('fail', '请输入有效价格长度, 当前长度: ' + target.toString().length)
        return false
    }
    if (target < 100) {
        setCurrentToastComponent('fail', '请输入有效价格数量, 当前价格: ' + target + '(' + target / 100 + ')')
        return false
    }
    return true
}


async function insert(information) {
    // 校验描述
    if (isBlank(information.markdownText)) {
        setCurrentToastComponent('fail', '请描述这个物品')
        return false
    } else {
        if (information.markdownText.toString().length <= 32) {
            setCurrentToastComponent('fail', '描述不能过短, 当前长度: ' + information.markdownText.toString().length)
            return false
        }
    }

    if (!isBlank(information.imageAddress)) {
        if (isBlank(information.imageAddress.regular)) {
            setCurrentToastComponent('fail', '请上传regular图片')
            return false
        }
        if (isBlank(information.imageAddress.hover)) {
            setCurrentToastComponent('fail', '请上传hover图片')
            return false
        }
    } else {
        setCurrentToastComponent('fail', '请先上传图片')
    }

    // 定义类型
    let type = null
    if (information.category !== '类型') {
        type = information.category.toLowerCase()
    } else {
        setCurrentToastComponent('fail', '请选择类型')
        return false
    }

    // 判断名称
    if (isBlank(information.name)) {
        setCurrentToastComponent('fail', '请输入名称')
        return false
    }

    // 判断价格
    if (isBlank(information.price)) {
        setCurrentToastComponent('fail', '请设置价格')
        return false
    } else {
        if (!priceCheck(information.price)) {
            return false
        }
    }

    // 判断指令
    if (isBlank(information.command)) {
        setCurrentToastComponent('fail', '请输入指令')
        return false
    }

    // extra是否打折
    let isDiscount = !isBlank(information.discount)
    if (isDiscount) {
        if (!discountCheck(information.discount)) {
            return false
        }
    }

    // crate是否打折
    let x1 = !isBlank(information.multiDiscount.x1)
    let x5 = !isBlank(information.multiDiscount.x5)
    let x10 = !isBlank(information.multiDiscount.x10)
    let x20 = !isBlank(information.multiDiscount.x20)
    if (x1 || x5 || x10 || x20) {
        if ((x1 && !discountCheck(information.multiDiscount.x1)) || (x5 && !discountCheck(information.multiDiscount.x5))) {
            return false
        }
        if (x10 && !discountCheck(information.multiDiscount.x10)) {
            return false
        }
        if (x20 && !discountCheck(information.multiDiscount.x20)) {
            return false
        }
    }

    const data = {
        type: information.category,
        name: information.name,
        price: information.price,
        saleCondition: null,
        rawSalePercent: null,
        command: information.command,
        imageAddress: information.imageAddress.regular,
        imageHoverAddress: information.imageAddress.hover,
        description: information.htmlText,
        rawDescription: information.markdownText
    }

    if (type === 'extras') {
        data.saleCondition = isDiscount
        data.rawSalePercent = information.discount
    } else {
        data.rawSalePercent = JSON.stringify(information.multiDiscount)
    }

    const {
        data: result
    } = await axios.post('local/admin/insert', data, {
        headers: {
            'Authorization': cookies.get('authorization')
        }
    })
    if (result.status === 200) {
        setCurrentToastComponent('success', '添加成功')
        localStorage.removeItem('cache-insert')
    } else {
        setCurrentToastComponent('fail', result.message)
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