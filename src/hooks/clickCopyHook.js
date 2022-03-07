import ClipboardJS from "clipboard";

export default function (selector) {
    let clipboard = new ClipboardJS(selector)
    clipboard.on('success', () => {
        clipboard.destroy();
    })
    clipboard.on('error', () => {
        clipboard.destroy();
    })
    return clipboard
}