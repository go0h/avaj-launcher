# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: astripeb <marvin@42.fr>                    +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2021/07/11 12:35:56 by astripeb          #+#    #+#              #
#    Updated: 2021/07/24 20:53:05 by astripeb         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #



GREEN 				:= \033[0;32m
RED 				:= \033[0;31m
RESET				:= \033[0m
BLINK				:= \033[5m
NORMAL				:= \033[25m
BOLDU				:= \033[1m\033[4m

NAME				:= avaj-launcher.jar


#COMPILER
CC 					:= javac

SRC_DIR				:= ./src
CLASSES_DIR			:= ./.classes

SRCS				:= $(shell find * -name "*.java")
CLASSES				:= $(SRCS:.java=.class)

################################################################################
#																	 		   #
################################################################################

all: $(NAME)

$(NAME): | $(CLASSES_DIR)
	$(CC) $(SRCS) -d $(CLASSES_DIR)
	jar -cvfe $(NAME) fr.fourtytwo.avaj.Main -C $(CLASSES_DIR) ./
	echo "$(GREEN)Creating $(BOLDU)$@$(RESET)"
	echo "$(GREEN)$(BLINK)DONE✅$(NORMAL)$(RESET)"

$(CLASSES_DIR):
	mkdir -p $@

clean:
	rm -rf $(CLASSES_DIR)
	echo "$(RED)Deleting $(BOLDU)classes files$(RESET)"

fclean: clean
	rm -rf $(NAME)
	echo "$(RED)Deleting $(BOLDU)$(NAME)$(RESET)"

re: fclean all

.SILENT: all clean re fclean $(NAME) $(CLASSES_DIR)

.PHONY: all clean re fclean
