import pubsub from "pubsub-js";

export default function setCurrentToastComponent(currentSlotName, msg) {
    let toastInformation = {
        currentSlotName: currentSlotName,
        msg: msg
    }
    pubsub.publish('setCurrentToastComponent', toastInformation)
}