#include <sys/select.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main() {
    fd_set fd;
    struct timeval tv;
    int ret;

    FD_ZERO(&fd);
    FD_SET(0, &fd);

    tv.tv_sec = 5;
    tv.tv_usec = 0;

    ret = select(1, &fd, NULL, NULL, &tv);
    printf("return value is %d\n", ret);

    if (ret == 0)
    {
	printf("select timeout\n");
    } else if (ret == -1)
    {
	printf("failed to select\n");
    } else
    {
	printf("data is available\n");
    }

    return 0;
}
