package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Fibonacci;
import main.Palindrome;
import main.Pell;

class RecursionTests {
	
	private static int STACK_DEPTH = 0;

	@BeforeAll
	static void stackDepthCounter() {
		try {
			stackDepthCounterRecurser();
		} catch (StackOverflowError ignored) {
		}
		STACK_DEPTH += 5;
	}

	private static void stackDepthCounterRecurser() {
		STACK_DEPTH++;
		stackDepthCounterRecurser();
	}
	
	
	
	@Test
	void fibonacciRecursionTest() {
		try {
			Fibonacci.memoFib(STACK_DEPTH);
			fail("Must implement this function using recursion");
		} catch (StackOverflowError ignored) {
		}
	}
	
	@Test
	void memoFibonacciTest() {
		assertTimeout(Duration.ofSeconds(60), () -> {
			assertEquals(BigInteger.valueOf(1), Fibonacci.memoFib(0),
					String.format("When n = %d, Fibonacci number is %d", 0, 1));
			assertEquals(BigInteger.valueOf(1), Fibonacci.memoFib(1),
					String.format("When n = %d, Fibonacci number is %d", 1, 1));
			assertEquals(BigInteger.valueOf(2), Fibonacci.memoFib(2),
					String.format("When n = %d, Fibonacci number is %d", 2, 2));
			assertEquals(BigInteger.valueOf(3), Fibonacci.memoFib(3),
					String.format("When n = %d, Fibonacci number is %d", 3, 3));
			assertEquals(BigInteger.valueOf(5), Fibonacci.memoFib(4),
					String.format("When n = %d, Fibonacci number is %d", 4, 5));
			assertEquals(BigInteger.valueOf(8), Fibonacci.memoFib(5),
					String.format("When n = %d, Fibonacci number is %d", 5, 8));
					
					
			assertEquals(new BigInteger("225591516161936330872512695036072072"
				+ "046011324913758190588638866418474627738686883405015987052796968498626"), 
				Fibonacci.memoFib(500),
					String.format("When n = %d, Fibonacci number is %s", 500, "225...626"));


			assertEquals(new BigInteger("70330367711422815821835254877183549770181"
				+ "269836358732742604905087154537118196933579742249494562611733487"
				+ "750449241765991088186363265450223647106012053374121273867339111"
				+ "198139373125598767690091902245245323403501"), 
				Fibonacci.memoFib(1000),
					String.format("When n = %d, Fibonacci number is %s", 1000, "703...501"));
					
			assertEquals(new BigInteger("683570225957580664704539654917058010705540"
				+ "8029365524565407553367798082454408054014954534318953113802726603"
				+ "7267695234474782381921927145266779399433383061014051054148197056"
				+ "6409090181363729645376709552810486826470491443352935557914873104"
				+ "4685634135487735897954629842516947101494253575869699893400976539"
				+ "5457402148198191519520850895384229545651467203837521219721157257"
				+ "61141759114990448978941370030912401573418221496592822626"), 
				Fibonacci.memoFib(2000),
					String.format("When n = %d, Fibonacci number is %s", 2000, "683...501"));
		}, "Did you forget to memoize Fibonacci?");
	}
	
	
	
	/**
	 * Tests the output of {@link PellNumbers#PellNumber(Integer)} for n values
	 * between 1 and 2310. Test must complete within 60 seconds, or else it will
	 * time out. This is put in place to prevent un-memoized methods from running
	 * for extended periods of time
	 */
	@Test
	void pellNumberTest() {
		assertTimeout(Duration.ofSeconds(60), () -> {
			assertEquals(BigInteger.valueOf(1), Pell.pellNumber(1),
					String.format("When n = %d, Pell's number is %d", 1, 1));
			assertEquals(BigInteger.valueOf(2), Pell.pellNumber(2),
					String.format("When n = %d, Pell's number is %d", 2, 2));
			assertEquals(BigInteger.valueOf(5), Pell.pellNumber(3),
					String.format("When n = %d, Pell's number is %d", 3, 5));
			assertEquals(BigInteger.valueOf(12), Pell.pellNumber(4),
					String.format("When n = %d, Pell's number is %d", 4, 12));
			assertEquals(BigInteger.valueOf(985), Pell.pellNumber(9),
					String.format("When n = %d, Pell's number is %d", 9, 985));
			assertEquals(BigInteger.valueOf(15994428), Pell.pellNumber(20),
					String.format("When n = %d, Pell's number is %d", 20, 15994428));

			assertEquals(new BigInteger("66992092050551637663438906713182313772"), Pell.pellNumber(100));
			assertEquals(new BigInteger("21093096734545788527500836634727099588489384390319004814017810623293211815789"
					+ "209911283798336840541227810827362247961462076340236731742628764087168306758128066643738616268"
					+ "857975982438181087665615915626282432004505944399554607844270641892800758687636009968274277222"
					+ "295140088568054131815535180156183128363609909859421735474877635959333893583537947135921530940"
					+ "258496573995974651586025272"), Pell.pellNumber(1000),
					String.format("When n = %d, Pell's number is %s", 1000, "2109...272"));
			assertEquals(new BigInteger("57582184532906785293777829954840254162930685491127185215437992984021607144389"
					+ "2297440763538244388702558773203675583398926090031865726959212909172272001117459665245717927477"
					+ "1161189503230929793540801662005078203227497856565383743430795146861082399982194609383725267843"
					+ "8263679665813881624796372875508570120377798631607586460933092846758126152613055661402864335558"
					+ "8623899186155596704034309833246303069272268159030566793794161054557600061640199911503659346894"
					+ "4773498982296960921022373429226260619235005143240934249788786657731086739591595441108608775191"
					+ "9346501643973115802048412185689540696829741377379995519304758757937050080281109170336026123180"
					+ "0444868985121173081393350307071539871580541558915330543952140639950439116213430257787263502393"
					+ "3454561917529043962226463194500591072542867756539720689357690167053203104873727961224316594081"
					+ "9545306414229147583130126048527155410190534814263066950"), Pell.pellNumber(2310),
					String.format("When n = %d, Pell's number is %s", 2310, "575...950"));
		}, "Did you forget to memoize Pell?");
	}

	/**
	 * Ensure {@link PellNumbers#PellNumber(Integer)} is implemented recursively by
	 * attempting to force a stack overflow
	 */
	@Test
	void pellNumberRecursionTest() {
		try {
			Pell.pellNumber(STACK_DEPTH);
			fail("Must implement this function using recursion");
		} catch (StackOverflowError ignored) {
		}
	}
	
	/**
	 * Test that the {@link Palindrome#isPalindrome(String)} is correct on a wide
	 * range of strings that may or may not be palindromes
	 */
	@Test
	void isPalindromeTest() {
		assertTrue(Palindrome.isPalindrome("tacocat"), "'tacocat' is a palindrome");
		assertTrue(Palindrome.isPalindrome("mom"), "'mom' is a palindrome");
		assertTrue(Palindrome.isPalindrome("dad"), "'dad' is a palindrome");
		assertTrue(Palindrome.isPalindrome("lol"), "'lol' is a palindrome");
		assertTrue(Palindrome.isPalindrome("a"), "'a' is a palindrome");
		assertTrue(Palindrome.isPalindrome(""), "the empty string is a palindrome");
		assertTrue(Palindrome.isPalindrome("aaaa"), "'aaaa' is a palindrome");
		assertTrue(Palindrome.isPalindrome("live evil"), "'live evil' is a palindrome");
		assertTrue(Palindrome.isPalindrome("graarg"), "'graarg' is a palindrome");
		assertTrue(Palindrome.isPalindrome("madam"), "'madam' is a palindrome");
		assertTrue(Palindrome.isPalindrome("radar"), "'radar' is a palindrome");
		assertTrue(Palindrome.isPalindrome("reviver"), "'reviver' is a palindrome");
		assertTrue(Palindrome.isPalindrome("rotator"), "'rotator' is a palindrome");
		assertTrue(Palindrome.isPalindrome("1010101010101"), "'1010101010101' is a palindrome");

		assertFalse(Palindrome.isPalindrome("Roscoe"), "'Roscoe' is not a palindrome");
		assertFalse(Palindrome.isPalindrome("CS222"), "'CS222' is not a palindrome");
		assertFalse(Palindrome.isPalindrome("Java"), "'Java' is not a palindrome");
		assertFalse(Palindrome.isPalindrome("tac ocat"), "'tac ocat' is not a palindrome");
		assertFalse(Palindrome.isPalindrome("Saint Marys College"), "'Saint Marys College' is not a palindrome");
		assertFalse(Palindrome.isPalindrome("This, most certainly, is not a palindromic sentence."),
				"'This, most certainly, is not a palindromic sentence.' speaks for itself. It's not a palindrome");
	}

	/**
	 * Ensure {@link Palindrome#isPalindrome(String)} is implemented recursively by
	 * attempting to force a stack overflow
	 */
	@Test
	void isPalindromeRecursionTest() {
		try {
			// double depth to allow for overflow
			Palindrome.isPalindrome("a".repeat(STACK_DEPTH * 2));
			fail("Must implement this function using recursion");
		} catch (StackOverflowError ignored) {
		}
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
