FROM node:latest
RUN mkdir -p /quizify
WORKDIR /quizify
COPY package.json /quizify/
RUN npm install --force
#RUN npm cache verify
RUN npm install @angular/cli -g
COPY . /quizify
EXPOSE 4200
CMD ["ng", "serve",  "--host", "0.0.0.0", "--poll", "2000","--disableHostCheck","true"]