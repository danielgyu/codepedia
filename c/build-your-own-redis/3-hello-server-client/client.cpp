#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/ip.h>


int main() {
    int fd = socket(AF_INET, SOCK_STREAM, 0);

    struct sockaddr_in addr = {};
    addr.sin_family = AF_INET;
    addr.sin_port = ntohs(1234);
    addr.sin_addr.s_addr = ntohl(INADDR_LOOPBACK);

    int rv = connect(fd, (const struct sockaddr *)&addr, sizeof(addr));
    if (rv) {
        // error
    }

    char msg[] = "hello";
    write(fd, msg, strlen(msg));

    char readbuf[64] = {};
    ssize_t n = read(fd, readbuf, sizeof(readbuf)-1);
    if (n < 0) {
        // error
    }

    printf("server says: %s\n", readbuf);
    close(fd);

    return 0;
}
