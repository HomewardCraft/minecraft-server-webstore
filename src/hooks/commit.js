import setCurrentToastComponent from "./setToastComponent.js";
import axios from "../commonPlugins/axios.js";

export default async function commit(information) {
    let hasCategory = information.category !== '类型'
    if (!hasCategory) {
        setCurrentToastComponent('fail', '请选择类型')
        return false
    }

    let hasName = information.name !== null
    if (!hasName) {
        setCurrentToastComponent('fail', '请输入名称')
        return false
    }

    let hasPrice = information.price !== null
    if (!hasPrice) {
        setCurrentToastComponent('fail', '请设置价格')
        return false
    }

    let hasCommand = information.command !== null
    if (!hasCommand) {
        setCurrentToastComponent('fail', '请输入指令')
        return false
    }

    let priceIsInteger = Number.isInteger(information.price)
    console.log(information)
    if (!priceIsInteger) {
        setCurrentToastComponent('fail', '请输入有效价格整数')
        return false
    }

    let priceLengthIsAvailable = information.price.toString().length <= 7
    if (!priceLengthIsAvailable) {
        console.log(information.price.toString().length)
        setCurrentToastComponent('fail', '请输入有效价格长度, 当前长度: ' + information.price.toString().length)
        return false
    }

    let priceAmount = information.price >= 100
    if (!priceAmount) {
        setCurrentToastComponent('fail', '请输入有效价格数量, 当前价格: ' + information.price + '(' + information.price / 100 + ')')
        return false
    }

    if (information.discount !== null) {
        let discountIsInteger = Number.isInteger(information.price)
        if (!discountIsInteger) {
            setCurrentToastComponent('fail', '请输入有效折扣整数')
            return false
        }

        let discountLengthIsAvailable = information.discount.toString().length <= 2
        if (!discountLengthIsAvailable) {
            setCurrentToastComponent('fail', '请输入有效折扣长度, 当前长度: ' + information.discount.toString().length)
            return false
        }

        let discountAmount = information.discount > 0
        if (!discountAmount) {
            setCurrentToastComponent('fail', '请输入有效折扣数量, 当前折扣: ' + information.discount + '%')
            return false
        }
    }

    const {
        data: result
    } = await axios.post('local/admin/insert', {
        category: information.category,
        name: information.name,
        price: information.price,
        discount: information.discount,
        command: information.command
    })

    console.log(result);
}