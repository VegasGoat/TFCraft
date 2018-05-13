package com.bioxx.tfc.Entities.AI;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;

public class EntityAIWanderNoFence extends EntityAIWander
{
	private EntityCreature entity;
	private double speed;

	public EntityAIWanderNoFence(EntityCreature entity, double speed)
	{
		super(entity, speed);
		this.entity = entity;
		this.speed = speed;
	}

	public void startExecuting()
	{
		super.startExecuting();

		// if the path contains a fence or gate, stop the path before then
		if(!this.entity.worldObj.isRemote)
		{
			PathEntity path = this.entity.getNavigator().getPath();
			if(path != null)
			{
				// check for fences on the path
				int ii;
				boolean sawNonFence = false;
				for(ii=0; ii<path.getCurrentPathLength(); ++ii)
				{
					PathPoint point = path.getPathPointFromIndex(ii);
					Block bl = this.entity.worldObj.getBlock(point.xCoord, point.yCoord, point.zCoord);
					if((bl instanceof BlockFence) || (bl instanceof BlockFenceGate))
					{
						// only stop at fence if path had other non-fence blocks
						// so they don't get stuck starting in fence blocks
						if(sawNonFence)
						{
							path.setCurrentPathLength(ii);
							break;
						}
					}
					else
					{
						sawNonFence = true;
					}

					if((sawNonFence) && (point.yCoord > 1))
					{
						// check below the path for a fence gate since they try and jump over it
						bl = this.entity.worldObj.getBlock(point.xCoord, point.yCoord-1, point.zCoord);
						if(bl instanceof BlockFenceGate)
						{
							path.setCurrentPathLength(ii);
							break;
						}
					}
				}
			}
		}
	}

	public static void replaceVanillaWander(EntityCreature entity, double speed)
	{
		int foundPri = -1;
		EntityAIBase foundTask = null;

		int ii;
		for(ii=0; ii<entity.tasks.taskEntries.size(); ++ii)
		{
			EntityAITasks.EntityAITaskEntry entry = (EntityAITasks.EntityAITaskEntry) entity.tasks.taskEntries.get(ii);
			if(entry.action instanceof EntityAIWander)
			{
				foundPri = entry.priority;
				foundTask = entry.action;
				break;
			}
		}

		if(foundTask != null)
		{
			entity.tasks.removeTask(foundTask);
			entity.tasks.addTask(foundPri, new EntityAIWanderNoFence(entity, speed));
		}
	}
}

