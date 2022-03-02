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
      }
    }
  }
})
