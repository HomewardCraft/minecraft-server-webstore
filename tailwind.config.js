const plugin = require("tailwindcss/plugin");
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
        },
        red: {
          '500': '#ff4343',
          '600': '#ff1313'
        },
        nav: {
          home: '#f18725',
          blog: '#22afdc',
          help: '#20b966',
        },
        lighten: 'hsla(0,0%,100%,0.3)',
        ip: {
          '400': '#ffe7c2',
          '700': '#edc30a',
          '800': '#bf6936',
          '900': '#ab5828',
          '1000': '#824610'
        },
        discord: {
          '800': '#5763c7',
          '900': '#3642a9'
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
  plugins: [
    plugin(function({ addVariant }) {
    })
  ],
}
