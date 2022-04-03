module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    container: {
      padding: {
        DEFAULT: '15px',
      }
    },
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
          '900': '#87522b'
        }
      },
      textColor: {
        'ip': {
          '700': '#edc30a',
          '900': '#ab5828',
          '1000': '#824610'
        }
      },
      margin: {
        '27.5': '110px',
      },
      gridTemplateRows: {
        'body': 'auto 1fr auto'
      },
    },
  },
  plugins: [],
}
