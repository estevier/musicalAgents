// file: MRAOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package com.moseph.mra;

import jade.content.onto.*;
import jade.content.schema.*;
import jade.util.leap.HashMap;
import jade.content.lang.Codec;
import jade.core.*;

/** file: MRAOntology.java
 * @author ontology bean generator
 * @version 2006/01/26, 14:34:55
 */
public class MRAOntology extends jade.content.onto.Ontology implements ProtegeTools.ProtegeOntology {
   /**
    * These hashmap store a mapping from jade names to either protege names of SlotHolder 
    * containing the protege names.  And vice versa
    */  
   private HashMap jadeToProtege;

  //NAME
  public static final String ONTOLOGY_NAME = "MRA";
  // The singleton instance of this ontology
  private static ProtegeIntrospector introspect = new ProtegeIntrospector();
  private static Ontology theInstance = new MRAOntology();
  public static Ontology getInstance() {
     return theInstance;
  }

   // ProtegeOntology methods
   public SlotHolder getSlotNameFromJADEName(SlotHolder jadeSlot) {
     return (SlotHolder) jadeToProtege.get(jadeSlot);
   }


   // storing the information
   private void storeSlotName(String jadeName, String javaClassName, String slotName){
       jadeToProtege.put(new SlotHolder(javaClassName, jadeName), new SlotHolder(javaClassName, slotName));
   }


   // VOCABULARY
    public static final String PLAY_PATH="path";
    public static final String PLAY_PLAYER="player";
    public static final String PLAY="Play";
    public static final String FRAGMENT="Fragment";
    public static final String CHANNEL="Channel";
    public static final String PIECE="Piece";
    public static final String UNIT_NAME="name";
    public static final String UNIT="Unit";
    public static final String SECTION="Section";
    public static final String SPANCONTAINER="SpanContainer";
    public static final String PATH_PATHSPEC="pathSpec";
    public static final String PATH="Path";

  /**
   * Constructor
  */
  private MRAOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    introspect.setOntology(this);
    jadeToProtege = new HashMap();
    try { 

    // adding Concept(s)
    ConceptSchema pathSchema = new ConceptSchema(PATH);
    add(pathSchema, com.moseph.mra.Path.class);
    ConceptSchema spanContainerSchema = new ConceptSchema(SPANCONTAINER);
    add(spanContainerSchema, com.moseph.mra.SpanContainer.class);
    ConceptSchema sectionSchema = new ConceptSchema(SECTION);
    add(sectionSchema, com.moseph.mra.Section.class);
    ConceptSchema unitSchema = new ConceptSchema(UNIT);
    add(unitSchema, com.moseph.mra.Unit.class);
    ConceptSchema pieceSchema = new ConceptSchema(PIECE);
    add(pieceSchema, com.moseph.mra.Piece.class);
    ConceptSchema channelSchema = new ConceptSchema(CHANNEL);
    add(channelSchema, com.moseph.mra.Channel.class);
    ConceptSchema fragmentSchema = new ConceptSchema(FRAGMENT);
    add(fragmentSchema, com.moseph.mra.Fragment.class);

    // adding AgentAction(s)
    AgentActionSchema playSchema = new AgentActionSchema(PLAY);
    add(playSchema, com.moseph.mra.Play.class);

    // adding AID(s)

    // adding Predicate(s)


    // adding fields
    pathSchema.add(PATH_PATHSPEC, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    unitSchema.add(UNIT_NAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    playSchema.add(PLAY_PATH, (ConceptSchema)getSchema(PATH), ObjectSchema.MANDATORY  );
    //playSchema.add(PLAY_PLAYER, (ConceptSchema)getSchema(AID.class.getName() ), ObjectSchema.MANDATORY  );

    // adding name mappings
    storeSlotName("pathSpec", "com.moseph.mra.Path", "pathSpec");  
    storeSlotName("name", "com.moseph.mra.Unit", "name");  
    storeSlotName("player", "com.moseph.mra.Play", "player");  
    storeSlotName("path", "com.moseph.mra.Play", "path");  

    // adding inheritance
    spanContainerSchema.addSuperSchema(channelSchema);
    sectionSchema.addSuperSchema(unitSchema);
    pieceSchema.addSuperSchema(sectionSchema);
    channelSchema.addSuperSchema(unitSchema);
    fragmentSchema.addSuperSchema(spanContainerSchema);

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
  }
