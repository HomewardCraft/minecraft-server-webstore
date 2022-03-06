import pubsub from "pubsub-js";

export default function setCurrentToastComponent(currentComponentName, itemMeta) {
    let currentComponent = {
        itemMeta: itemMeta,
        componentName: currentComponentName
    }
    pubsub.publish('setCurrentToastComponent', currentComponent)
}