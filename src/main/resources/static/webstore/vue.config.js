//项目配置
module.exports = {

    // pages: {
    //
    //     index: {
    //         //入口
    //         // entry: 'src/index/main.js'
    //     }
    //
    // },

    lintOnSave: false, //关闭语法检查

    devServer: {
        proxy: {
            '#': { // 匹配所有以 '/#'开头的请求路径
                target: 'http://localhost:5001', // 代理目标的基础路径
                pathRewrite: {'^/#': ''},
                ws: true, //用于支持websocket
                changeOrigin: true //用于控制请求头中的host值
            }
        }
    }
    /*
   changeOrigin设置为true时，服务器收到的请求头中的host为：localhost:5000
   changeOrigin设置为false时，服务器收到的请求头中的host为：localhost:8080
   changeOrigin默认值为true
    */


}