#include <fcntl.h>
#include <stdio.h>
#include <sys/poll.h>
#include <sys/time.h>
#include <unistd.h>

#define TIMEOUT 5

int main(int argc, char **argv) 
{
    struct pollfd pfds[2];
    int ret;

    while (1) {
	pfds[0].fd = STDIN_FILENO;
	pfds[0].events = POLLIN;

	pfds[1].fd = STDOUT_FILENO;
	pfds[1].events = POLLOUT;

	ret = poll(pfds, 2, TIMEOUT * 1000);

	if (ret == -1) {
	    perror("poll");
	    return 1;
	}

	if (!ret) {
	    printf("%d seconds elapsed\n", TIMEOUT);
	}

	if (pfds[0].revents & POLLIN) {
	    printf("stdin is readable\n");
	}

	if (pfds[1].revents & POLLOUT) {
	    printf("stdin is writable\n");
	}

	return 0;
    }
}
