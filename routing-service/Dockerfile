################
# Run in NGINX #
################
FROM nginx:alpine

COPY nginx.conf /etc/nginx/nginx.conf

ARG CALENDAR_SERVICE_PORT
ARG CALENDAR_SERVICE_HOST

RUN apk add --no-cache curl

COPY /nginx.conf /etc/nginx/nginx.template.conf
RUN envsubst '$$CALENDAR_SERVICE_PORT $$CALENDAR_SERVICE_HOST' < /etc/nginx/nginx.template.conf > /etc/nginx/nginx.conf

CMD ["/bin/sh",  "-c",  "exec nginx -g 'daemon off;'"]