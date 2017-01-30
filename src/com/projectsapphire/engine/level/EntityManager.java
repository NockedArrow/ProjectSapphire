package com.projectsapphire.engine.level;

public class EntityManager {

	public PC pc;
	public final int npcCOUNT;
	public NPC[] npc;
	
	public EntityManager(int npcCount) {
		pc = new PC();
		
		this.npcCOUNT = npcCount - 1;
		npc = new NPC[npcCOUNT];
		for (int i = 0; i < npcCOUNT; i++)
			npc[i] = new NPC();
	}

	public void render() {
		pc.update();
		pc.render();
		
		for (Entity entity : npc){
			entity.update();
			entity.render();
		}
	}

	public int countInside() {
		int count = 0;
		for (Entity entity : npc) {
			if(!entity.isNotInside()) {
				count++;
			}
		}
		return count + 1;
	}
}
