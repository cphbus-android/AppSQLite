package pets

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import app.App
import org.jetbrains.anko.db.*

class PetController(var context: Context = App.instance) : ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    lateinit var db: SQLiteDatabase

    companion object {
        val DB_NAME = "PetDB"
        val DB_VERSION = 1
        val instance by lazy { PetController() }
    }

    override fun onCreate(database: SQLiteDatabase) {
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    fun setup() {

        val dbExists = context.getDatabasePath("PetDB").exists()

        db = writableDatabase

        db.createTable(
                PetTable.tableName, true,
                PetTable.petID to INTEGER + PRIMARY_KEY,
                PetTable.petName to TEXT,
                PetTable.petAge to INTEGER
        )

        db.close()
    }

    fun savePet(p: Pet) {
        db = writableDatabase

//        db.insert(PetTable.petName, *pa.map.toVarargArray())

        db.close()
    }

    fun addPet(petname: String, petage: Int) {

        db = writableDatabase

        db.insert(
                PetTable.tableName,
                PetTable.petName to petname,
                PetTable.petAge to petage
        )

        db.close()
    }

    fun deletePet(petid: Int) {

        db = writableDatabase

        db.delete("Pet", "${PetTable.petID} = ${petid}")

        db.close()
    }

    fun getPets(): List<Map<String, Any?>> {

        db = readableDatabase

        return db.select("Pet").exec() {
            parseList(
                    object : MapRowParser<Map<String, Any?>> {
                        override fun parseRow(columns: Map<String, Any?>): Map<String, Any?> {
                            return columns
                        }
                    })
        }

        db.close()
    }

    fun getPetByMinAge(age: Int) {
        db = readableDatabase
/*
        val request = "${PetTable.petAge} >= ?"
        db.select(PetTable.petName)
                .whereSimple(request, age.toString())
                .parseList { Pet(HashMap(it)) }
*/
        db.close()
    }


    fun setupMore() {
        /*
        db.execSQL("CREATE TABLE IF NOT EXISTS pets (" +
                "petID INTEGER PRIMARY KEY NOT NULL," +
                "petName TEXT, " +
                "petAge INTEGER" +
                ")")

        db.execSQL("CREATE TABLE IF NOT EXISTS pets (" +
                "petID INTEGER PRIMARY KEY NOT NULL," +
                "petName TEXT, " +
                "petAge INTEGER" +
                ")")

        db.execSQL("CREATE TABLE IF NOT EXISTS products (" +
                "productID INTEGER PRIMARY KEY NOT NULL," +
                "productName CHAR(50) NOT NULL, " +
                "productDescription TEXT" +
                ")")

        db.execSQL("CREATE TABLE IF NOT EXISTS organisations (petID INTEGER PRIMARY KEY);")

        db.execSQL("CREATE TABLE IF NOT EXISTS users (petID INTEGER PRIMARY KEY, name TEXT, avatarurl TEXT);")

        db.createTable(
                PersTable.name, true,
                PersTable.petID to INTEGER + PRIMARY_KEY,
                PersTable.firstName to TEXT,
                PersTable.lastName to TEXT,
                PersTable.age to INTEGER,
                PersTable.email to TEXT
        )

        db.dropTable("organisations", true)
        */
    }

    fun query() {
        /*
        db.insert(
                PersTable.name,
                PersTable.firstName to "Kurt",
                PersTable.lastName to "Hansen",
                PersTable.age to 51,
                PersTable.email to "kurt@hansen.dk"
        )
        db.insert(
                PersTable.name,
                PersTable.petID to 2,
                PersTable.firstName to "Sonja",
                PersTable.lastName to "Jensen",
                PersTable.age to 15,
                PersTable.email to "sonja@mail.dk"
        )

        db.update(
                PersTable.name,
                PersTable.firstName to "Sofie",
                PersTable.lastName to "Hansen",
                PersTable.email to "Sofie@hansen.dk"
        )
                .where("${PersTable.petID} = 2")
                .exec()


        db.deletePet("Pers", "${PersTable.petID} = 1")

        var persons: List<Map<String, Any?>> = db.select("Pers").exec() {
            parseList(
                    object : MapRowParser<Map<String, Any?>> {
                        override fun parseRow(columns: Map<String, Any?>): Map<String, Any?> {
                            return columns
                        }
                    })
        }

        Log.d("DebugPersons", "SelectSize" + persons.size)
        Log.d("DebugPersons", "SelectGetRow" + persons.get(0))
        Log.d("DebugPersons", "SelectGetColumn" + persons.get(0)["email"])
        */

        //db.close()
    }

    //context.deleteDatabase("TESTDB")
}


