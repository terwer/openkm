import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

const MODULE_NAME = "/appstore/"
const isProduction = process.env.NODE_ENV == "production";
console.log("isProduction:" + isProduction)

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    // 项目根目录
    // root: process.cwd(),
    root: './',
    // 项目部署的基础路径
    base: isProduction ? MODULE_NAME : "",
    // 静态资源服务文件夹
    publicDir: 'public',
    build: {
        rollupOptions: {
            output: {
                chunkFileNames: 'static/js/[name]-[hash].js',
                entryFileNames: 'static/js/[name]-[hash].js',
                assetFileNames: 'static/[ext]/[name]-[hash].[ext]',
            },
        }
    }
})