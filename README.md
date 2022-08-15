clone this repository

Run mvn clean install

Run your application provided in Docker

Run this application on local

I have added filter and sort as optional features for first endpoint.
For filtering provide any String and for sorting provide the values from enum only as below
{SIZE,TYPE,DELETED,NAME}

example: curl --location --request GET 'http://localhost:8081/documents?category=cat_1&sortBy=SIZE'

Second endpoint is for metadata and this also has filtering feature

example: curl --location --request GET 'http://localhost:8081/documents/metaInfo?category=cat_1'