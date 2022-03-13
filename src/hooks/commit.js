import setCurrentToastComponent from "./setToastComponent.js";
import axios from "../commonPlugins/axios.js";

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

async function commit(information) {
    if (information.markdownText !== null) {
        if (information.markdownText.toString().length <= 32) {
            setCurrentToastComponent('fail', '描述不能过短, 当前长度: ' + information.markdownText.toString().length)
            return false
        }
    } else {
        setCurrentToastComponent('fail', '请描述这个物品')
        return false
    }

    if (information.imageAddress !== {}) {
        if (information.imageAddress.regular === null || information.imageAddress.regular === '') {
            setCurrentToastComponent('fail', '请完整上传图片')
            return false
        }
    } else {
        setCurrentToastComponent('fail', '请先上传图片')
    }

    let type = null

    if (information.category !== '类型') {
        type = information.category.toLowerCase()
    } else {
        setCurrentToastComponent('fail', '请选择类型')
        return false
    }


    if (information.name === null) {
        setCurrentToastComponent('fail', '请输入名称')
        return false
    }


    if (information.price !== null) {
        let priceIsPass = priceCheck(information.price)
        if (!priceIsPass) {
            return false
        }
    } else {
        setCurrentToastComponent('fail', '请设置价格')
        return false
    }


    if (information.command === null) {
        setCurrentToastComponent('fail', '请输入指令')
        return false
    }

    let isDiscount = information.discount !== null

    if (isDiscount) {
        let isPass = discountCheck(information.discount)
        if (!isPass) {
            return false
        }
    }


    let x1 = information.multiDiscount.x1
    let x5 = information.multiDiscount.x5
    let x10 = information.multiDiscount.x10
    let x20 = information.multiDiscount.x20
    let isMultiDiscount = x1 !== null || x5 !== null || x10 !== null || x20 !== null

    if (isMultiDiscount) {
        if (x1 !== null && x1 !== '') {
            discountCheck(x1)
        }
        if (x5 !== null && x5 !== '') {
            discountCheck(x5)
        }
        if (x10 !== null && x10 !== '') {
            discountCheck(x10)
        }
        if (x20 !== null && x20 !== '') {
            discountCheck(x20)
        }
    }


    if (type === 'extra') {
        const {
            data: result
        } = await axios.post('local/admin/insert', {
            type: information.category,
            name: information.name,
            price: information.price,
            onSale: isDiscount,
            discount: information.discount,
            command: information.command,
            description: information.description,
            imageAddress: information.imageAddress.regular
        })
        console.log(result)
        if (result.status === 200) {
            setCurrentToastComponent('success', '添加成功')
        } else {
            setCurrentToastComponent('fail', '添加失败')
        }
    } else if (type === 'crate') {
        const {
            data: result
        } = await axios.post('local/admin/insert', {
                type: information.category,
                name: information.name,
                price: information.price,
                onSale: isMultiDiscount,
                multiDiscount: JSON.stringify(information.multiDiscount),
                command: information.command,
                description: information.markdownText,
                imageAddress: information.imageAddress.regular
            })
        console.log(result)
        if (result.status === 200) {
            setCurrentToastComponent('success', '添加成功')
        } else {
            setCurrentToastComponent('fail', '添加失败')
        }
    }
}

export default commit