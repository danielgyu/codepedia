#include <iostream>
#include <string.h>
#include <stdio.h>
#include <unistd.h>


int MAX_ARG_LENGTH = 256;
int PATH_MAX = 256;

char* parseArgs(int argc, char* argv[]) {
  int num = 2;
  int argBufferLength = 0;
  char* argBuffer = new char[MAX_ARG_LENGTH];

  while (num < argc) {
    char* targetArg = argv[num++];
    size_t argLength = strlen(targetArg);
    for (size_t i=0; i<argLength; i++) {
      argBuffer[argBufferLength++] = targetArg[i];
    }
    argBuffer[argBufferLength++] = ' ';
  }
  argBuffer[argBufferLength] = 0;
  return argBuffer;
}

int runCommand(const char* parsedArgs) {
  char* cmd = new char[MAX_ARG_LENGTH];
  strcpy(cmd,  parsedArgs);
  strcat(cmd, " 2>&1");

  FILE *fp;
  fp = popen(parsedArgs, "r");
  if (!fp) {
    std::cout << "popen error" << std::endl;
    return 1;
  }

  char path[PATH_MAX];
  while (fgets(path, PATH_MAX, fp) != NULL) {
    std::cout << path;
  }

  int status = pclose(fp);
  return status == 0 ? 0 : 2;
}

int main(int argc, char* argv[]) {
  if (argc < 3) {
    std::cout << "wrong number of arguments" << std::endl;
    return 2;
  }

  if (strcmp(argv[1], "run") != 0) {
    std::cout << "non-recognizable command" << std::endl;
    return 2;
  }

  if (sethostname("ccrun-container", 15) != 0) {
    perror("sethostname error occurred");
    return 2;
  };
  
  const char* parsedArgs = parseArgs(argc, argv);
  return runCommand(parsedArgs);
}
