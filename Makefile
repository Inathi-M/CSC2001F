#Makefile for Assignment 2
#Nkosinathi Tshaphile
#28 March 2022

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<
	
CLASSES=BinaryTreeNode.class BTQueueNode.class   BTQueue.class  BinaryTree.class AVLTree.class AVLExperiment.class  
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
         


clean: 
	rm $(BINDIR)/*.class
	
run: $(CLASS_FILES)
	java -cp $(BINDIR) AVLExperiment  