module.exports = {
  content: [
    "./src/**/*.{vue,js,ts,jsx,tsx}",
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
        '88': '22rem',
        '144': '36rem',
        '110': '27.5rem'
      },
      gridTemplateRows: {
        'body': 'auto 1fr auto'
      },
      colors: {
        custom: {
          700: '#f4b174',
          900: '#dc8a16',
          1000: '#a35710',
          1100: '#AB5828'
        }
      }
    }
  }
}
