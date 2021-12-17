docker run  --name mysql5-task -v /lib/mysql/data:/var/lib/mysql -p 3309:3309 -e MYSQL_ROOT_PASSWORD=password -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
