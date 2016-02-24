package com.aeroc.tfc.OreMod;

import java.util.Random;

import com.bioxx.tfc.api.TFCBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class KimberlitePipe {
	
	public int x, y, z;
	
	public KimberlitePipe( int x, int y, int z ){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void generate( World world, Random random ){
		
		//Determine the maximum height of the pipe
		int tallestRock = 0;
		for( int i = 255; i > 0 && tallestRock == 0; i-- ){ //Find the highest rock, to complete the start position for veins
			if( TFCOreModWorldGenOre.isRock( world.getBlock( this.x, i, this.z ) ) ){
				tallestRock = i;
			}
		}
		int pipeHeight = tallestRock - this.y; //Should always be positive
		int radius = 2;
		for( int i = 0; i < pipeHeight; ){
			for( int j = 0 - ( radius - 1 ); j < radius; j++ ){
				for( int k = 0 - ( radius - 1 ); k < radius; k++ ){
					
					if( Math.abs( j ) + Math.abs( k ) < radius ){	//Making the pipe a diamond shape instead of a square shape
						if( this.isRockOrMineral( world.getBlock( this.x + j, i, this.z + k ) ) ){
							world.setBlock( this.x + j, this.y + i, this.z + k, TFCMineral.kimberlite.block, TFCMineral.kimberlite.meta, 0x2 );
						}
					}
				}
			}
			//Increment i
			i++;
			int pipeCompletion = i * 100 / pipeHeight; //The percent of the way up the pipe has generated so far
			if( pipeCompletion > 90 ){
				radius = 5;
			}
			else if( pipeCompletion > 75 ){
				radius = 4;
			}
			else if( pipeCompletion > 50 ){
				radius = 3;
			}
		}
	}
	private boolean isRockOrMineral( Block b ){
        if( b == TFCBlocks.stoneIgIn || b == TFCBlocks.stoneIgEx || 
            b == TFCBlocks.stoneMM || b == TFCBlocks.stoneSed ||
            b == TFCBlocks.ore || b == TFCBlocks.ore2 || b == TFCBlocks.ore3 ){
            return true;
        }
        return false;
    }
}
