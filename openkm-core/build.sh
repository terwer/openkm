#!/bin/sh
GROUP_ID=$(./mvnw org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.groupId|grep -Ev '(^\[|Download\w+:)')
ARTIFACT_ID=$(./mvnw org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.artifactId|grep -Ev '(^\[|Download\w+:)')
APP_VERSION=$(./mvnw org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version|grep -Ev '(^\[|Download\w+:)')
echo "读取配置完毕."

# 前端
echo "构建前端..."
cd src/main/webapp
pnpm i && pnpm run build
cd ../../../

echo '构建后端...'
chmod +x mvnw
# 打包
./mvnw clean package -DskipTests -V -e
echo '构建完毕.'

./mvnw install -DskipTests
echo '安装jar完毕.'

# 安装提供给插件引用的pom
cp pom.xml pom-parent.xml
# linux
# sed -i s/<packaging>.*<\/packaging>/<packaging>pom<\/packaging>/" pom-parent.xml
# mac
sed -i "" "s/<packaging>.*<\/packaging>/<packaging>pom<\/packaging>/" pom-parent.xml
# 安装pom
./mvnw install:install-file -DskipTests -Dfile=pom-parent.xml -DgroupId=${GROUP_ID} -DartifactId=${ARTIFACT_ID} -Dversion=${APP_VERSION} -Dpackaging=pom
echo '安装pom完毕.'

echo '安装core完毕.'