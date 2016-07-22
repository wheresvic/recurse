from random import random

def drawCar(carPosition):
    return reduce(lambda a, x: a + '-', range(carPosition), '')

def drawCarPositions(carPositions):
	return reduce(lambda a, x: a + drawCar(x) + '\n', carPositions, '')

def turn(carPositions):
	newCarPositions = map(lambda x : x+1 if (random() > 0.3) else x, carPositions)
	output = drawCarPositions(newCarPositions)
	print output
	return newCarPositions

time = 5;
carPositions = [1, 1, 1]
    
finalCarPositions = reduce(lambda a, x: turn(a), range(time), carPositions)
