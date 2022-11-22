FROM node:16.15.0 as build-stage
WORKDIR /var/jenkins_home/workspace/deply/frontend
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /var/jenkins_home/workspace/deply/frontend/dist /var/www/html
COPY --from=build-stage /var/jenkins_home/workspace/deply/frontend/deply_conf/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g","daemon off;"]
