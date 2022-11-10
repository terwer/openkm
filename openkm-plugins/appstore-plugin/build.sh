#!/bin/sh

echo "开始构建..."

# 前端
echo "构建前端..."
cd ui
pnpm i && pnpm run build
cd ../
cp -r ui/dist/ src/main/resources/static

# 插件资源
cp plugin.properties src/main/resources

# 后端
echo "构建后端..."
./mvnw clean package -DskipTests

# 清理
echo "清理资源..."
rm src/main/resources/plugin.properties
rm -rf ui/dist/

echo "构建完毕."
