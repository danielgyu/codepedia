#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define IPC_KEY_FILENAME	"/Users/a202206033/Personal"
#define IPC_KEY_PROJ_ID		'a'
#define MSGBUF_BUF_SIZE 	64

struct msgbuf {
	long mtype;
	char buf[MSGBUF_BUF_SIZE];
};

static void print_usage(const char *progname)
{
	printf("%s (send | recv) (mtype)\n", progname);
}

static int init_msgq(void)
{
	int msq_id;
	key_t key;

	key = ftok(IPC_KEY_FILENAME, IPC_KEY_PROJ_ID);
	if (key == -1) {
		perror("ftok()");
		return -1;
	}

	msq_id = msgget(key, 0644 | O_CREAT);
	if (msq_id == -1) {
		perror("msgget()");
		return -1;
	}

	return msq_id;
}

static int do_send(long mtype)
{
	int msq_id;
	struct msgbuf mbuf;

	msq_id = init_msgq();
	if (msq_id == -1) {
		perror("init_msgq()");
		return -1;
	}

	memset(&mbuf, 0, sizeof(mbuf));
	mbuf.mtype = mtype;
	strncpy(mbuf.buf, "hello world", sizeof(mbuf.buf)-1);

	if (msgsnd(msq_id, &mbuf, sizeof(mbuf.buf), 0) == -1) {
		perror("msgsnd()");
		return -1;
	}
	
	return 0;
}

static int do_recv(long mtype)
{
	int ret;
	int msq_id;
	struct msgbuf mbuf;

	msq_id = init_msgq();
	if (msq_id == -1) {
		perror("init_msgq()");
		return -1;
	}

	memset(&mbuf, 0, sizeof(mbuf));

	ret = msgrcv(msq_id, &mbuf, sizeof(mbuf.buf), mtype, 0);
	if (ret == -1) {
		perror("msgsnd()");
		return -1;
	}
	printf("received: mtype %ld, msg[%s]\n", mbuf.mtype, mbuf.buf);

	return 0;
}

int main(int argc, char **argv)
{
	int ret;
	long mtype;

	if (argc < 3) {
		print_usage(argv[0]);
		return -1;
	}

	mtype = strtol(argv[2], NULL, 10);

	if (!strcmp(argv[1], "send")) {
		if (mtype <= 0) {
			print_usage(argv[0]);
			return -1;
		}
		ret = do_send(mtype);
	} else if (!strcmp(argv[1], "recv")) {
		ret = do_recv(mtype);
	} else {
		return -1;
	}

	return 0;
}
