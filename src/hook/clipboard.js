import ClipboardJS from "clipboard";

const copy = (selector) => {
    const clipboard = new ClipboardJS(selector)
    clipboard.on('success', () => {
        clipboard.destroy()
    })
    clipboard.on('error', () => {
        clipboard.destroy()
    })
    return clipboard
}

export {copy}