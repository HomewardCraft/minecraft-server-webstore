module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    screens: {
      sm: '640px',
      md: '768px',
      lg: '992px',
      xl: '1100px'
    },
    extend: {
      colors: {
        yellow: {
          '400': '#fac000',
          '500': '#eaa21a',
          '600': '#d68512',
        }
      },
      textColor: {
        'ip': {
          '1000': '#824610',
          '700': '#edc30a'
        }
      },
      margin: {
        '27.5': '110px'
      },
      gridTemplateRows: {
        'body': 'auto 1fr auto'
      },
    },
  },
  plugins: [],
}
