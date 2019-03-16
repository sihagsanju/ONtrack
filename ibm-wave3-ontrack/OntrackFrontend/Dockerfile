FROM node:latest
RUN mkdir -p /OntrackFrontend
WORKDIR /OntrackFrontend
COPY package.json /OntrackFrontend/
RUN npm install --force
#RUN npm cache verify
RUN npm install @angular/cli -g
COPY . /OntrackFrontend
EXPOSE 4200
CMD ["ng", "serve",  "--host", "0.0.0.0", "--poll", "2000","--disableHostCheck","true"]
