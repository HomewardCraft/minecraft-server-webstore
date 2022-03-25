import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/mojang': {
        target: 'https://api.mojang.com/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/mojang/, '')
      },
      '/backend': {
        target: 'https://ba1oretto.com/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/backend/, '')
      },
      '/local': {
        target: 'http://127.0.0.1:50012/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/local/, '')
      }
    }
  }
})
