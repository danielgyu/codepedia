#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/ip.h>


void read_message(int connfd) {
    char readbuf[64] = {};
    ssize_t n = read(connfd, readbuf, sizeof(readbuf) - 1);
    if (n < 0) {
        // error
        return;
    }
    printf("client says: %s\n", readbuf);
}

void write_message(int connfd) {
    char writebuf[] = "world";
    write(connfd, writebuf, strlen(writebuf));
}

void do_something(int connfd) {
    read_message(connfd);
    write_message(connfd);
}

void runServer()
{
    int fd = socket(AF_INET, SOCK_STREAM, 0);
    if (fd < 0) {
        // error
    }

    int val = 1;
    setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));

    struct sockaddr_in addr = {};
    addr.sin_family = AF_INET;
    addr.sin_port = ntohs(1234);
    addr.sin_addr.s_addr = ntohl(0);
    int rv = bind(fd, (const sockaddr *)&addr, sizeof(addr));
    if (rv) {
        // error
    }

    rv = listen(fd, SOMAXCONN);
    if (rv) {
        // error
    }

    while (true) {
        struct sockaddr_in client_addr = {};
        socklen_t socklen = sizeof(client_addr);
        int connfd = accept(fd, (struct sockaddr *)&client_addr, &socklen);

        if (connfd <0) {
            // error
        }
        do_something(connfd);
        close(connfd);
    }
}

int main()
{
    runServer();
    return 0;
}
