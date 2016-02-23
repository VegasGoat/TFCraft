package com.bioxx.tfc.OreMod;

import com.bioxx.tfc.api.TFCBlocks;

import net.minecraft.block.Block;

public class TFCRock {
	public Block block;
	public int meta;
	
	public static TFCRock granite = new TFCRock( TFCBlocks.stoneIgIn, 0 );
	public static TFCRock diorite = new TFCRock( TFCBlocks.stoneIgIn, 1 );
	public static TFCRock gabbro = new TFCRock( TFCBlocks.stoneIgIn, 2 );
	
	public static TFCRock rhyolite = new TFCRock( TFCBlocks.stoneIgEx, 0 );
	public static TFCRock basalt = new TFCRock( TFCBlocks.stoneIgEx, 1 );
	public static TFCRock andesite = new TFCRock( TFCBlocks.stoneIgEx, 2 );
	public static TFCRock dacite = new TFCRock( TFCBlocks.stoneIgEx, 3 );
	
	public static TFCRock siltstone = new TFCRock( TFCBlocks.stoneSed, 0 );
	public static TFCRock mudstone = new TFCRock( TFCBlocks.stoneSed, 1 );
	public static TFCRock shale = new TFCRock( TFCBlocks.stoneSed, 2 );
	public static TFCRock claystone = new TFCRock( TFCBlocks.stoneSed, 3 );
	public static TFCRock rockSalt = new TFCRock( TFCBlocks.stoneSed, 4 );
	public static TFCRock limestone = new TFCRock( TFCBlocks.stoneSed, 5 );
	public static TFCRock conglomerate = new TFCRock( TFCBlocks.stoneSed, 6 );
	public static TFCRock dolomite = new TFCRock( TFCBlocks.stoneSed, 7 );
	public static TFCRock chert = new TFCRock( TFCBlocks.stoneSed, 8 );
	public static TFCRock chalk = new TFCRock( TFCBlocks.stoneSed, 9 );
	
	public static TFCRock quartzite = new TFCRock( TFCBlocks.stoneMM, 0 );
	public static TFCRock slate = new TFCRock( TFCBlocks.stoneMM, 1 );
	public static TFCRock phyllite = new TFCRock( TFCBlocks.stoneMM, 2 );
	public static TFCRock schist = new TFCRock( TFCBlocks.stoneMM, 3 );
	public static TFCRock gneiss = new TFCRock( TFCBlocks.stoneMM, 4 );
	public static TFCRock marble = new TFCRock( TFCBlocks.stoneMM, 5 );
	
	public TFCRock( Block block, int meta ){
		this.block = block;
		this.meta = meta;
	}
}
