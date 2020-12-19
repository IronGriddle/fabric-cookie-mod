Stream.of(
Block.makeCuboidShape(7, 8, 3, 12, 10, 7),
Block.makeCuboidShape(7, 0, 1, 10, 12, 13),
Block.makeCuboidShape(7, 6, 9, 12, 9, 11),
Block.makeCuboidShape(6.606854196949072, 1.9217984375897625, 7, 10.606854196949072, 4.9217984375897625, 9),
Block.makeCuboidShape(6, 4, 2, 11, 7, 5)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});