package com.projectsapphire.engine.level;

import com.projectsapphire.engine.maths.Relations;

public class EntityManager {

	public PC pc;
	public int npcCOUNT;
	public int itemCOUNT;
	public NPC[] npc;

	public EntityManager(int npcCount) {
		pc = new PC();

		this.npcCOUNT = npcCount;
		npc = new NPC[npcCOUNT];
		for (int i = 0; i < npcCOUNT; i++) {
			npc[i] = new NPC();
			npc[i].setEntityID(i);
		}
	}

	public void render() {
		pc.update();
		pc.render();

		for (Entity entity1 : npc) {
			if(npcCOUNT > 1)
				for (Entity entity2 : npc){
					if(entity1.getEntityID() != entity2.getEntityID())
						if(Relations.checkCollision(entity1, entity2)){
							((NPC) entity1).collided();
							((NPC) entity2).collided();
						}
				}
			if(Relations.checkCollision(entity1, pc))
				((NPC) entity1).collided();
		}


		for (Entity entity1 : npc) {
			entity1.update();
			entity1.render();
		}
	}

	public int countInside(String string) {
		int count = 0;

		if(string=="NPC")
			for (Entity entity : npc)
				if(!entity.isNotInside())
					count++;

		return count;
	}
}
