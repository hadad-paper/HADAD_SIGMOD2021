package hadad.base.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RegisterMetaData {
//
//    public static void registerMetaData() throws Exception {
//
//        Parameters.init();
//        Catalog catalog = Catalog.getInstance();
//        catalog.delete();
//        //************************* Case 1 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQL1 = getPostgresSQLStorageReference1("V1_JSONT");
//        // Columns names
//        final List<String> colNames = new ArrayList<String>();
//        colNames.add("SUBJECT_ID");
//        colNames.add("HADM_ID");
//        colNames.add("LABEL");
//
//        // NRSMD
//        final NRSMD NRSMD = new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE,
//                TupleMetadataType.INTEGER_TYPE, TupleMetadataType.STRING_TYPE }, colNames);
//        final Map<String, Integer> serviceNRSMDMapping = new HashMap<>();
//        serviceNRSMDMapping.put("SUBJECT_ID", 0);
//        serviceNRSMDMapping.put("HADM_ID", 1);
//        serviceNRSMDMapping.put("LABEL", 2);
//        ViewSchema serviceSchema = new ViewSchema(NRSMD, serviceNRSMDMapping);
//        catalog.add("V1_JSONT", storageReferencePostgresSQL1, null, serviceSchema);
//
//        final StorageReference storageReferencePostgresSQL2 = getPostgresSQLStorageReference2("V_PATIENTS");
//        // Columns names
//        final List<String> colNames2 = new ArrayList<String>();
//        colNames2.add("SUBJECT_ID");
//        colNames2.add("DOB");
//        colNames2.add("GENDER");
//
//        // NRSMD
//        final NRSMD NRSMD2 = new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE,
//                TupleMetadataType.STRING_TYPE, TupleMetadataType.STRING_TYPE }, colNames2);
//        final Map<String, Integer> serviceNRSMDMapping2 = new HashMap<>();
//        serviceNRSMDMapping2.put("SUBJECT_ID", 0);
//        serviceNRSMDMapping2.put("DOB", 1);
//        serviceNRSMDMapping2.put("GENDER", 2);
//
//        ViewSchema serviceSchema2 = new ViewSchema(NRSMD2, serviceNRSMDMapping2);
//        catalog.add("V_PATIENTS", storageReferencePostgresSQL2, null, serviceSchema2);
//
//        final StorageReference storageReferenceSolr2 = getSolrStorageReference("Notes");
//        // Columns names
//        final List<String> colNames3 = new ArrayList<String>();
//        colNames3.add("subject_id");
//        colNames3.add("hadm_id");
//        colNames3.add("text");
//
//        // NRSMD
//        final NRSMD NRSMD3 = new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE,
//                TupleMetadataType.INTEGER_TYPE, TupleMetadataType.STRING_TYPE }, colNames3);
//        final Map<String, Integer> serviceNRSMDMapping3 = new HashMap<>();
//        serviceNRSMDMapping3.put("SUBJECT_ID", 0);
//        serviceNRSMDMapping3.put("HADM_ID", 1);
//        serviceNRSMDMapping3.put("TEXT", 2);
//        ViewSchema serviceSchema3 = new ViewSchema(NRSMD3, serviceNRSMDMapping3);
//        catalog.add("Notes", storageReferenceSolr2, null, serviceSchema3);
//
//        //************************* Case 2 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV2_JSONT = getPostgresSQLStorageReference1("V2_JSONT");
//        // Columns names
//        final List<String> colNamesV2_JSONT = new ArrayList<String>();
//        colNamesV2_JSONT.add("SUBJECT_ID");
//        colNamesV2_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV2_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV2_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV2_JSONT = new HashMap<>();
//        serviceNRSMDMappingV2_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV2_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV2_JSONT = new ViewSchema(NRSMDV2_JSONT, serviceNRSMDMappingV2_JSONT);
//        catalog.add("V2_JSONT", storageReferencePostgresSQLV2_JSONT, null, serviceSchemaV2_JSONT);
//
//        //************************* Case 3 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV3_JSONT = getPostgresSQLStorageReference1("V3_JSONT");
//        // Columns names
//        final List<String> colNamesV3_JSONT = new ArrayList<String>();
//        colNamesV3_JSONT.add("SUBJECT_ID");
//        colNamesV3_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV3_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV2_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV3_JSONT = new HashMap<>();
//        serviceNRSMDMappingV3_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV3_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV3_JSONT = new ViewSchema(NRSMDV3_JSONT, serviceNRSMDMappingV3_JSONT);
//        catalog.add("V3_JSONT", storageReferencePostgresSQLV3_JSONT, null, serviceSchemaV3_JSONT);
//
//        //************************* Case4 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV4_JSONT = getPostgresSQLStorageReference1("V4_JSONT");
//        // Columns names
//        final List<String> colNamesV4_JSONT = new ArrayList<String>();
//        colNamesV4_JSONT.add("SUBJECT_ID");
//        colNamesV4_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV4_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV4_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV4_JSONT = new HashMap<>();
//        serviceNRSMDMappingV4_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV4_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV4_JSONT = new ViewSchema(NRSMDV4_JSONT, serviceNRSMDMappingV4_JSONT);
//        catalog.add("V4_JSONT", storageReferencePostgresSQLV4_JSONT, null, serviceSchemaV4_JSONT);
//
//        //************************* Case5 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV5_JSONT = getPostgresSQLStorageReference1("V5_JSONT");
//        // Columns names
//        final List<String> colNamesV5_JSONT = new ArrayList<String>();
//        colNamesV5_JSONT.add("SUBJECT_ID");
//        colNamesV5_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV5_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV4_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV5_JSONT = new HashMap<>();
//        serviceNRSMDMappingV5_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV5_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV5_JSONT = new ViewSchema(NRSMDV5_JSONT, serviceNRSMDMappingV5_JSONT);
//        catalog.add("V5_JSONT", storageReferencePostgresSQLV5_JSONT, null, serviceSchemaV5_JSONT);
//
//        //************************* Case6 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV6_JSONT = getPostgresSQLStorageReference1("V6_JSONT");
//        // Columns names
//        final List<String> colNamesV6_JSONT = new ArrayList<String>();
//        colNamesV6_JSONT.add("SUBJECT_ID");
//        colNamesV6_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV6_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV4_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV6_JSONT = new HashMap<>();
//        serviceNRSMDMappingV6_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV6_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV6_JSONT = new ViewSchema(NRSMDV6_JSONT, serviceNRSMDMappingV6_JSONT);
//        catalog.add("V6_JSONT", storageReferencePostgresSQLV6_JSONT, null, serviceSchemaV6_JSONT);
//
//        //************************* Case7 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV7_JSONT = getPostgresSQLStorageReference1("V7_JSONT");
//        // Columns names
//        final List<String> colNamesV7_JSONT = new ArrayList<String>();
//        colNamesV7_JSONT.add("SUBJECT_ID");
//        colNamesV7_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV7_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV4_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV7_JSONT = new HashMap<>();
//        serviceNRSMDMappingV7_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV7_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV7_JSONT = new ViewSchema(NRSMDV7_JSONT, serviceNRSMDMappingV7_JSONT);
//        catalog.add("V7_JSONT", storageReferencePostgresSQLV7_JSONT, null, serviceSchemaV7_JSONT);
//
//        //************************* Case8 ****************************//
//        // Register
//        final StorageReference storageReferencePostgresSQLV8_JSONT = getPostgresSQLStorageReference1("V8_JSONT");
//        // Columns names
//        final List<String> colNamesV8_JSONT = new ArrayList<String>();
//        colNamesV8_JSONT.add("SUBJECT_ID");
//        colNamesV8_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV8_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV8_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV8_JSONT = new HashMap<>();
//        serviceNRSMDMappingV8_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV8_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV8_JSONT = new ViewSchema(NRSMDV8_JSONT, serviceNRSMDMappingV8_JSONT);
//        catalog.add("V8_JSONT", storageReferencePostgresSQLV8_JSONT, null, serviceSchemaV8_JSONT);
//
//        //************************* Case10 ****************************//
//
//        final StorageReference storageReferencePostgresSQLV10_JSONT = getPostgresSQLStorageReference1("V10_JSONT");
//        // Columns names
//        final List<String> colNamesV10_JSONT = new ArrayList<String>();
//        colNamesV10_JSONT.add("SUBJECT_ID");
//        colNamesV10_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV10_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV10_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV10_JSONT = new HashMap<>();
//        serviceNRSMDMappingV10_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV10_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV10_JSONT = new ViewSchema(NRSMDV10_JSONT, serviceNRSMDMappingV10_JSONT);
//        catalog.add("V10_JSONT", storageReferencePostgresSQLV10_JSONT, null, serviceSchemaV10_JSONT);
//
//        //************************* Case11 ****************************//
//
//        final StorageReference storageReferencePostgresSQLV11_JSONT = getPostgresSQLStorageReference1("V11_JSONT");
//        // Columns names
//        final List<String> colNamesV11_JSONT = new ArrayList<String>();
//        colNamesV11_JSONT.add("SUBJECT_ID");
//        colNamesV11_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV11_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV11_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV11_JSONT = new HashMap<>();
//        serviceNRSMDMappingV11_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV11_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV11_JSONT = new ViewSchema(NRSMDV11_JSONT, serviceNRSMDMappingV11_JSONT);
//        catalog.add("V11_JSONT", storageReferencePostgresSQLV11_JSONT, null, serviceSchemaV11_JSONT);
//
//        //************************* Case12 ****************************//
//
//        final StorageReference storageReferencePostgresSQLV12_JSONT = getPostgresSQLStorageReference1("V12_JSONT");
//        // Columns names
//        final List<String> colNamesV12_JSONT = new ArrayList<String>();
//        colNamesV12_JSONT.add("SUBJECT_ID");
//        colNamesV12_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV12_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV11_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV12_JSONT = new HashMap<>();
//        serviceNRSMDMappingV12_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV12_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV12_JSONT = new ViewSchema(NRSMDV12_JSONT, serviceNRSMDMappingV12_JSONT);
//        catalog.add("V12_JSONT", storageReferencePostgresSQLV12_JSONT, null, serviceSchemaV12_JSONT);
//
//        //************************* Case13 ****************************//
//        final StorageReference storageReferencePostgresSQLV13_JSONT = getPostgresSQLStorageReference1("V13_JSONT");
//        // Columns names
//        final List<String> colNamesV13_JSONT = new ArrayList<String>();
//        colNamesV13_JSONT.add("SUBJECT_ID");
//        colNamesV13_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV13_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV13_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV13_JSONT = new HashMap<>();
//        serviceNRSMDMappingV13_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV13_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV13_JSONT = new ViewSchema(NRSMDV13_JSONT, serviceNRSMDMappingV13_JSONT);
//        catalog.add("V13_JSONT", storageReferencePostgresSQLV13_JSONT, null, serviceSchemaV13_JSONT);
//
//        //************************* Case14 ****************************//
//        final StorageReference storageReferencePostgresSQLV14_JSONT = getPostgresSQLStorageReference1("V14_JSONT");
//        // Columns names
//        final List<String> colNamesV14_JSONT = new ArrayList<String>();
//        colNamesV14_JSONT.add("SUBJECT_ID");
//        colNamesV14_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV14_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV14_JSONT = new HashMap<>();
//        serviceNRSMDMappingV14_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV14_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV14_JSONT = new ViewSchema(NRSMDV14_JSONT, serviceNRSMDMappingV14_JSONT);
//        catalog.add("V14_JSONT", storageReferencePostgresSQLV14_JSONT, null, serviceSchemaV14_JSONT);
//
//        //************************* Case15 ****************************//
//        final StorageReference storageReferencePostgresSQLV15_JSONT = getPostgresSQLStorageReference1("V15_JSONT");
//        // Columns names
//        final List<String> colNamesV15_JSONT = new ArrayList<String>();
//        colNamesV15_JSONT.add("SUBJECT_ID");
//        colNamesV15_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV15_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV15_JSONT = new HashMap<>();
//        serviceNRSMDMappingV15_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV15_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV15_JSONT = new ViewSchema(NRSMDV15_JSONT, serviceNRSMDMappingV15_JSONT);
//        catalog.add("V15_JSONT", storageReferencePostgresSQLV15_JSONT, null, serviceSchemaV15_JSONT);
//
//        //************************* Case16 ****************************//
//        final StorageReference storageReferencePostgresSQLV16_JSONT = getPostgresSQLStorageReference1("V16_JSONT");
//        // Columns names
//        final List<String> colNamesV16_JSONT = new ArrayList<String>();
//        colNamesV16_JSONT.add("SUBJECT_ID");
//        colNamesV16_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV16_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV16_JSONT = new HashMap<>();
//        serviceNRSMDMappingV16_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV16_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV16_JSONT = new ViewSchema(NRSMDV16_JSONT, serviceNRSMDMappingV16_JSONT);
//        catalog.add("V16_JSONT", storageReferencePostgresSQLV16_JSONT, null, serviceSchemaV16_JSONT);
//
//        //************************* Case17 ****************************//
//        final StorageReference storageReferencePostgresSQLV17_JSONT = getPostgresSQLStorageReference1("V17_JSONT");
//        // Columns names
//        final List<String> colNamesV17_JSONT = new ArrayList<String>();
//        colNamesV17_JSONT.add("SUBJECT_ID");
//        colNamesV17_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV17_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV17_JSONT = new HashMap<>();
//        serviceNRSMDMappingV7_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV17_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV17_JSONT = new ViewSchema(NRSMDV17_JSONT, serviceNRSMDMappingV17_JSONT);
//        catalog.add("V17_JSONT", storageReferencePostgresSQLV17_JSONT, null, serviceSchemaV17_JSONT);
//
//        //************************* Case18 ****************************//
//        final StorageReference storageReferencePostgresSQLV18_JSONT = getPostgresSQLStorageReference1("V18_JSONT");
//        // Columns names
//        final List<String> colNamesV18_JSONT = new ArrayList<String>();
//        colNamesV18_JSONT.add("SUBJECT_ID");
//        colNamesV18_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV18_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV18_JSONT = new HashMap<>();
//        serviceNRSMDMappingV18_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV18_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV18_JSONT = new ViewSchema(NRSMDV18_JSONT, serviceNRSMDMappingV18_JSONT);
//        catalog.add("V18_JSONT", storageReferencePostgresSQLV18_JSONT, null, serviceSchemaV18_JSONT);
//
//        //************************* Case21 ****************************//
//        final StorageReference storageReferencePostgresSQLV21_JSONT = getPostgresSQLStorageReference1("V21_JSONT");
//        // Columns names
//        final List<String> colNamesV21_JSONT = new ArrayList<String>();
//        colNamesV21_JSONT.add("SUBJECT_ID");
//        colNamesV21_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV21_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV21_JSONT = new HashMap<>();
//        serviceNRSMDMappingV21_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV21_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV21_JSONT = new ViewSchema(NRSMDV21_JSONT, serviceNRSMDMappingV21_JSONT);
//        catalog.add("V21_JSONT", storageReferencePostgresSQLV21_JSONT, null, serviceSchemaV21_JSONT);
//
//        //************************* Case23 ****************************//
//        final StorageReference storageReferencePostgresSQLV23_JSONT = getPostgresSQLStorageReference1("V23_JSONT");
//        // Columns names
//        final List<String> colNamesV23_JSONT = new ArrayList<String>();
//        colNamesV23_JSONT.add("SUBJECT_ID");
//        colNamesV23_JSONT.add("HADM_ID");
//
//        // NRSMD
//        final NRSMD NRSMDV23_JSONT =
//                new NRSMD(3, new TupleMetadataType[] { TupleMetadataType.INTEGER_TYPE, TupleMetadataType.INTEGER_TYPE },
//                        colNamesV14_JSONT);
//        final Map<String, Integer> serviceNRSMDMappingV23_JSONT = new HashMap<>();
//        serviceNRSMDMappingV23_JSONT.put("SUBJECT_ID", 0);
//        serviceNRSMDMappingV23_JSONT.put("HADM_ID", 1);
//        ViewSchema serviceSchemaV23_JSONT = new ViewSchema(NRSMDV23_JSONT, serviceNRSMDMappingV23_JSONT);
//        catalog.add("V23_JSONT", storageReferencePostgresSQLV23_JSONT, null, serviceSchemaV23_JSONT);
//
//    }
//
//    private static StorageReference getPostgresSQLStorageReference1(String collectionName) throws Exception {
//        final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/mimic?user=postgres&password=postgres";
//        StorageReference gsr = new GSR(collectionName);
//        gsr.setProperty("url", POSTGRES_URL);
//        gsr.setProperty("modelId", "PJ");
//
//        return gsr;
//    }
//
//    private static StorageReference getPostgresSQLStorageReference2(String collectionName) throws Exception {
//        final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/mimic?user=postgres&password=postgres";
//        StorageReference gsr = new GSR(collectionName);
//        gsr.setProperty("url", POSTGRES_URL);
//        gsr.setProperty("modelId", "PR");
//
//        return gsr;
//    }
//
//    private static StorageReference getSolrStorageReference(String collectionName) throws Exception {
//        StorageReference gsr = new GSR(collectionName);
//        gsr.setProperty("url", SolrDatabaseLoader.DEFAULT_SOLR_URL);
//        gsr.setProperty("serverPort", SolrDatabaseLoader.DEFAULT_SOLR_PORT);
//        gsr.setProperty("coreName", collectionName);
//        gsr.setProperty("modelId", "SJ");
//
//        return gsr;
//
//    }

}
