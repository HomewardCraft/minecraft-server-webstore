const getPostColor = (type) => {
    switch (type.toString().toLowerCase()) {
        case 'update': return 'color: rgb(245, 183, 43)'
        case 'dev blog': return 'color: rgb(51, 241, 127)'
        case 'event': return 'color: rgb(67, 204, 218)'
        case 'misc': return 'color: rgb(255, 134, 218)'
    }
}
const getPostURL =(name) => {
    return '/blog/' + name
}
const getImageAddress = (address) => {
    return 'background-image: url(' + address + ')'
}

export {getPostColor, getPostURL, getImageAddress}