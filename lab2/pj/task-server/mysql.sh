docker run  --name mysql5-task -v /lib/mysql/data:/var/lib/mysql -p 3309:3306 -e MYSQL_ROOT_PASSWORD=password -d mariadb:10.5.8 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
