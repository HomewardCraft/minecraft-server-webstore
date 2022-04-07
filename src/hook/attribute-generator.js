const getTagColor = (tagColor) => {
    return 'color: #' + tagColor
}

const getPostURL =(name) => {
    return '/blog/' + name
}

const getImageAddress = (address) => {
    return 'background-image: url(' + address + ')'
}

const getDate = (datetime) => {
    const date = new Date(datetime);
    const dateList = date.toDateString().split(' ');
    const month = dateList[1]
    const day = dateList[2].replace('0', '')
    const year = dateList[3]
    const ordinal = (day) => {
        if (day > 3 && day < 21) return 'th'
        switch (day % 10) {
            case 1: return 'st'
            case 2: return 'nd'
            case 3: return 'rd'
            default: return 'th'
        }
    }
    return month + ' ' + day + ordinal(day) + ', ' + year
}

export {getTagColor, getPostURL, getImageAddress, getDate}