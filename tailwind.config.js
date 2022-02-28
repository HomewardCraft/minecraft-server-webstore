module.exports = {
  // 将tailwind样式表记为首选
  // important: true,
  // 分隔符默认为:
  separator: ':',
  //
  content: [
    './public/**/*.html',
    './src/components/*.{js,jsx,ts,tsx,vue}',
    './src/pages/*.{js,jsx,ts,tsx,vue}',
    './src/store/*.{js,jsx,ts,tsx,vue}',
    './src/router/*.{js,jsx,ts,tsx,vue}',
    './src/*.{js,jsx,ts,tsx,vue}',
  ],
  darkMode: 'class',
  // 添加tailwind的选择器的字首
  // prefix: 'tw-',

  // 主题配置
  theme: {
    // 响应式断点
    // screens: {
    //   sm: '480px',
    //   md: '768px',
    //   lg: '976px',
    //   xl: '1440px',
    // },

    // 继承默认配置
    extend: {
      // 拓展后缀
      spacing: {
        '128': '32rem',
        '144': '36rem',
        '110': '27.5rem'
      },
      gridTemplateRows: {
        'body': 'auto 1fr auto'
      }
    }
  }
}
