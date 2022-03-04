module.exports = {
  content: [
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  darkMode: 'class',
  theme: {
    screens: {
      sm: '640px',
      md: '768px',
      lg: '992px',
      xl: '1100px',
      mdm: {'max': '768px'}
    },
    extend: {
      spacing: {
        '88': '22rem',
        '100': '100px',
        '110': '110px',
        '128': '32rem',
        '144': '36rem'
      },
      gridTemplateRows: {
        'body': 'auto 1fr auto'
      },
      colors: {
        btn: {
          text: '#97438f'
        },
        black: {
          '80': '#000c'
        },
        gray: {
          '500': '#b3b7bc',
          '750': '#1d2021',
          '800': '#181a1b',
          '900': '#0d0e0f'
        },
        yellow: {
          '400': '#fac021',
          '800': '#92400e',
        },
        custom: {
          '300': '#fac021',
          '400': '#ffe7c2',
          '500': '#3642a9',
          '600': '#5763c7',
          '700': '#f4b174',
          '800': '#bf6936',
          '900': '#dc8a16',
          '1000': '#a35710',
          '1100': '#ab5828',
          '1200': '#181a1b'
        },
        navigator: {
          home: '#22afdc',
          blog: '#20b966',
          help: '#f18725',
        },
        light: '#ffffff1a',
        lighten: '#ffffff4d',
      },
      boxShadow: {
        'btn': '#d07fbe 0 5px 0'
      },
      backgroundColor: {
        'btn': '#ffb0e2'
      },
      textColor: {
        'black': '#000000'
      }
    }
  }
}
