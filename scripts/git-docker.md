# remove last two commits
`git reset --hard HEAD~2`
# kill all running containers in docker
`docker kill $(docker ps -q)`  
# run a docker jupyter notebook from pwd
`docker run -p 8888:8888 -v $(pwd):/home/jovyan/work jupyter/scipy-notebook`
# run docker "ant" image
`docker run -it --rm -v "$PWD":/app -w /app frekele/ant:latest ant`
# remove <none> images in docker
`docker rmi $(docker images -f "dangling=true" -q)`
# composer 
`docker run --rm -v $(pwd):/app composer/composer install`
# docker run php7
`docker run --rm -v $(pwd):/app -p 8080:80 -w /app php:7.0.4-fpm php -S 0.0.0.0:80 -t web`
# compile node webpack
`docker run --rm -v $(pwd):/app -w /app node:8 node node_modules/webpack/bin/webpack.js`