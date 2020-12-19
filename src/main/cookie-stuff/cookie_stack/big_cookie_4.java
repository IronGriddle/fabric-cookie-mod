Stream.of(
Block.makeCuboidShape(2, -1, 2, 14, 2, 14),
Block.makeCuboidShape(2, 2, 2, 14, 5, 14),
Block.makeCuboidShape(2, 5, 2, 14, 8, 14),
Block.makeCuboidShape(2, 8, 2, 14, 11, 14)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});