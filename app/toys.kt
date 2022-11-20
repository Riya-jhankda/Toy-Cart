data class toys(var title: String)
{
    var price : Int = 0;
    var description: String = "";
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        other as toys

        if (title != other.title) return false
        if (price != other.price) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + price
        result = 31 * result + description.hashCode()
        return result
    }
    //  var price : String = "";


}
