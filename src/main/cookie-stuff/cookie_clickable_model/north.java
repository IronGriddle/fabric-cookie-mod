Stream.of(
Block.makeCuboidShape(4, 8, 5, 8, 10, 10),
Block.makeCuboidShape(2, 0, 7, 14, 12, 10),
Block.makeCuboidShape(10, 6, 5, 12, 9, 10),
Block.makeCuboidShape(8, 1.9217984375897625, 6.393145803050928, 10, 4.9217984375897625, 10.393145803050928),
Block.makeCuboidShape(3, 4, 6, 6, 7, 11)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});