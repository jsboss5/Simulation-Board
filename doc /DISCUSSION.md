William Clark whc10
Josh Boss jsb91


# List as many design issues as you can in the method associated with the issue

checkScore - 
too many try catchs, can we seperate into one big try catch?
Too deeply nested conditionals, refactor into extracted methods
can refacator file path into constant variable

checkPowerUpPlatformCollision -
can add to platform/powerup class, there is duplicated code here
violates open closed principles, cannot extend without modification

# Organization

Top priorities are following the open closed principle; duplicate code is something that we don't want to see.
How we handle errors should be changed, too many try catchs, can we handle errors in a better way? Also, we should have
zero magic variables.

# Specific steps to fix design issues

Too many try catchs- add Exception throws to the method signature
Too deeply nested conditionals- extract methods for method single purpose
Magic variables- create private constants and replace
Can fix duplicated code in power up by implemented the polymorphism and overriding methods
We can fix the violation of the open closed principle by overriding the method in powerup in the three powerup subclasses,
and then simply calling that method once





