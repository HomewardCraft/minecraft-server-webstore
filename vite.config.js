import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/fantang': {
        target: 'https://fantang.cc/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/fantang/, '')
      },

      '/local': {
        target: 'http://127.0.0.1:50012/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/local/, '')
      }
    }
  }
})
