#include <sys/select.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main() {
    fd_set fd;
    struct timeval tv;
    int err;

    FD_ZERO(&fd);
    FD_SET(0, &fd);

    tv.tv_sec = 5;
    tv.tv_usec = 0;

    err = select(1, &fd, NULL, NULL, &tv);

    if (err == 0)
    {
	printf("select timeout\n");
    } else if (err == -1)
    {
	printf("failed to select");
    } else
    {
	printf("data is available");
    }

    return 0;
}
